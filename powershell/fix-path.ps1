
$newPath = "C:\Program Files\ConEmu\ConEmu\Scripts;C:\Program Files\ConEmu;C:\Program Files\ConEmu\ConEmu;C:\ProgramData\Oracle\Java\javapath;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\ATI Technologies\ATI.ACE\Core-Static;C:\Program Files\OpenVPN\bin;C:\Program Files (x86)\PuTTY\;C:\Program Files\dotnet\;C:\Program Files (x86)\Skype\Phone\;C:\Program Files\Microsoft SQL Server\130\Tools\Binn\;E:\APPLICATIONS\apache-ant-1.9.4-bin\bin;C:\Users\zinaliev\AppData\Local\Microsoft\WindowsApps"

Set-ItemProperty -Path ‘Registry::HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment’ -Name PATH –Value $newPath

echo "PATH hass been updated to:"
echo("-----------------")
(Get-ItemProperty -Path ‘Registry::HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment’ -Name PATH).Path
echo("-----------------")
echo "Restart console to use new PATH"

