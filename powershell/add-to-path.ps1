$newVar = $args[0]
#echo "passed var is - $newVar"

$oldPath = (Get-ItemProperty -Path ‘Registry::HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment’ -Name PATH).path
#echo "old path -  $oldPath"

$newPath = "$oldPath;$newVar"

Set-ItemProperty -Path ‘Registry::HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment’ -Name PATH –Value $newPath

echo "PATH hass been updated to:"
echo("-----------------")
(Get-ItemProperty -Path ‘Registry::HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment’ -Name PATH).Path
echo("-----------------")
echo "Restart console to use new PATH"

