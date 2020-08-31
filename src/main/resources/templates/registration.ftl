<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    Registration
    ${message}
    <@l.login "/registration" />
</@c.page>