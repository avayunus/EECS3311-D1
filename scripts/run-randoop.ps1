# Regenerate Randoop tests for non-GUI, non-file-I/O classes (D3).
# Run from project root:  powershell -File scripts\run-randoop.ps1

$ErrorActionPreference = "Stop"
$root = Split-Path -Parent (Split-Path -Parent $MyInvocation.MyCommand.Path)
Set-Location $root

New-Item -ItemType Directory -Force -Path "target\classes" | Out-Null
$sources = Get-ChildItem "src" -Recurse -Filter "*.java" | ForEach-Object { $_.FullName }
javac -encoding UTF-8 -cp "lib\javacsv.jar" -d "target\classes" $sources

@(
"scheduler.model.Booking",
"scheduler.model.BookingFactory",
"scheduler.model.Room",
"scheduler.model.TimeSlot",
"scheduler.model.User",
"scheduler.rules.NoOverlapRule",
"scheduler.strategy.StudentPricingStrategy",
"scheduler.strategy.FacultyPricingStrategy",
"scheduler.strategy.StaffPricingStrategy",
"scheduler.strategy.PartnerPricingStrategy",
"scheduler.data.InMemoryBookingRepository",
"scheduler.booking.BookingManager"
) | Set-Content -Encoding ASCII "randoop-classlist.txt"

Remove-Item -Recurse -Force "Randoop\scheduler" -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Force -Path "Randoop" | Out-Null

java -classpath "target\classes;lib\javacsv.jar;randoop-lib\randoop-all-4.2.1.jar" `
  randoop.main.Main gentests `
  --classlist=randoop-classlist.txt `
  --output-limit=500 `
  --time-limit=45 `
  --junit-package-name=scheduler.randoop `
  --junit-output-dir=Randoop

Write-Host "Done. Tests are in Randoop\scheduler\randoop\"
Write-Host "Run coverage with Maven:"
Write-Host '  & "..\tools\apache-maven-3.9.6\bin\mvn.cmd" test'
Write-Host "Then open target\site\jacoco\index.html"
