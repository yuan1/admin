<#macro content title keywords="" description="">
<html lang="zh_CN">
<head>
    <title>${title}</title>
    <meta name="keywords" content="${keywords}" />
    <meta name="description" content="${description}" />
    <#include "../layout/common.ftl">
</head>
<body style="overflow: hidden">
    <#nested>
</body>
</html>
</#macro>