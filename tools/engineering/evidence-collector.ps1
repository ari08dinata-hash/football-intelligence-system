# ==========================================
# Football Intelligence System (FISS)
# Engineering Evidence Collector v1.0
# ==========================================

$ScriptDirectory = Split-Path -Parent $MyInvocation.MyCommand.Path
$RepositoryRoot = Resolve-Path (Join-Path $ScriptDirectory "..\..")
$ArtifactDirectory = Join-Path $RepositoryRoot "artifacts"
$EvidenceFile = Join-Path $ArtifactDirectory "Repository-Evidence-Package-v1.0.md"

Write-Host "========================================="
Write-Host " Football Intelligence System (FISS)"
Write-Host " Engineering Evidence Collector v1.0"
Write-Host "========================================="
Write-Host ""

# Create artifacts directory if needed
if (-not (Test-Path $ArtifactDirectory)) {
    New-Item -ItemType Directory -Path $ArtifactDirectory | Out-Null
    Write-Host "[OK] Artifacts directory created."
}
else {
    Write-Host "[OK] Artifacts directory already exists."
}

# Reset evidence file
"" | Set-Content $EvidenceFile

# =========================================
# REP-E001
# Repository Root Structure
# =========================================

"" | Add-Content $EvidenceFile
"## REP-E001 Repository Root Structure" | Add-Content $EvidenceFile
"" | Add-Content $EvidenceFile

Get-ChildItem $RepositoryRoot |
    Select-Object Name, Mode |
    Format-Table -AutoSize |
    Out-String |
    Add-Content $EvidenceFile

# =========================================
# REP-E002
# settings.gradle.kts
# =========================================

"" | Add-Content $EvidenceFile
"## REP-E002 settings.gradle.kts" | Add-Content $EvidenceFile
"" | Add-Content $EvidenceFile

$File = Join-Path $RepositoryRoot "settings.gradle.kts"

if (Test-Path $File) {
    Get-Content $File | Add-Content $EvidenceFile
}
else {
    "settings.gradle.kts NOT FOUND" | Add-Content $EvidenceFile
}

# =========================================
# REP-E003
# build.gradle.kts
# =========================================

"" | Add-Content $EvidenceFile
"## REP-E003 build.gradle.kts" | Add-Content $EvidenceFile
"" | Add-Content $EvidenceFile

$File = Join-Path $RepositoryRoot "build.gradle.kts"

if (Test-Path $File) {
    Get-Content $File | Add-Content $EvidenceFile
}
else {
    "build.gradle.kts NOT FOUND" | Add-Content $EvidenceFile
}

# =========================================
# REP-E004
# gradle.properties
# =========================================

"" | Add-Content $EvidenceFile
"## REP-E004 gradle.properties" | Add-Content $EvidenceFile
"" | Add-Content $EvidenceFile

$File = Join-Path $RepositoryRoot "gradle.properties"

if (Test-Path $File) {
    Get-Content $File | Add-Content $EvidenceFile
}
else {
    "gradle.properties NOT FOUND" | Add-Content $EvidenceFile
}

# =========================================
# REP-E005
# libs.versions.toml
# =========================================

"" | Add-Content $EvidenceFile
"## REP-E005 libs.versions.toml" | Add-Content $EvidenceFile
"" | Add-Content $EvidenceFile

$File = Join-Path $RepositoryRoot "gradle\libs.versions.toml"

if (Test-Path $File) {
    Get-Content $File | Add-Content $EvidenceFile
}
else {
    "gradle\libs.versions.toml NOT FOUND" | Add-Content $EvidenceFile
}

# =========================================
# REP-E006
# README.md
# =========================================

"" | Add-Content $EvidenceFile
"## REP-E006 README.md" | Add-Content $EvidenceFile
"" | Add-Content $EvidenceFile

$File = Join-Path $RepositoryRoot "README.md"

if (Test-Path $File) {
    Get-Content $File | Add-Content $EvidenceFile
}
else {
    "README.md NOT FOUND" | Add-Content $EvidenceFile
}

# =========================================
# REP-E007
# .gitignore
# =========================================

"" | Add-Content $EvidenceFile
"## REP-E007 .gitignore" | Add-Content $EvidenceFile
"" | Add-Content $EvidenceFile

$File = Join-Path $RepositoryRoot ".gitignore"

if (Test-Path $File) {
    Get-Content $File | Add-Content $EvidenceFile
}
else {
    ".gitignore NOT FOUND" | Add-Content $EvidenceFile
}

Write-Host ""
Write-Host "[OK] Evidence package generated:"
Write-Host $EvidenceFile
