Write-Host "========================================="
Write-Host " Football Intelligence System (FISS)"
Write-Host " Engineering Evidence Collector v1.0"
Write-Host "========================================="
Write-Host ""

# =========================================
# Repository Root
# =========================================
$RepositoryRoot = Get-Location

# =========================================
# Artifact Directory
# =========================================
$ArtifactDirectory = Join-Path $RepositoryRoot "artifacts"

if (!(Test-Path $ArtifactDirectory)) {
    New-Item -ItemType Directory -Path $ArtifactDirectory | Out-Null
    Write-Host "[OK] Created artifacts directory."
}
else {
    Write-Host "[OK] Artifacts directory already exists."
}

# =========================================
# Evidence File
# =========================================
$EvidenceFile = Join-Path $ArtifactDirectory "Repository-Evidence-Package-v1.0.md"

"# Repository Evidence Package v1.0" | Set-Content $EvidenceFile
"" | Add-Content $EvidenceFile

# =========================================
# REP-E001
# Repository Root Structure
# =========================================

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

$SettingsFile = Join-Path $RepositoryRoot "settings.gradle.kts"

if (Test-Path $SettingsFile) {
    Get-Content $SettingsFile | Add-Content $EvidenceFile
}
else {
    "settings.gradle.kts NOT FOUND" | Add-Content $EvidenceFile
}

Write-Host ""
Write-Host "[OK] Evidence package generated:"
Write-Host $EvidenceFile
