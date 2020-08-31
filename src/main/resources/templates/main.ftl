<#import "parts/common.ftl" as c>
<#import  "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout/>
    </div>
    <a href="http://localhost:8080/">Back to Home Page</a>
    <br/>
    <div>
        Add any Message
        <form method="post" action="/main">
            <input type="text" name="text" placeholder="Enter your message.."/>
            <input type="text" name="tag" placeholder="Tag"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Add</button>
        </form>
    </div>
    <br/>
    <div>Message List:</div>
        <form method="get" action="/main">
            <input type="text" name="filter" value="${filter}"  placeholder="Add filter.."/>
            <button type="submit">Find</button>
        </form>
        <#list messages as message>
            <div>
                <b>${message.id}</b>
                <span>${message.text}</span>
                <i>${message.tag}</i>
                <strong>${message.authorName}</strong>
            </div>
        <#else>
            No messages
        </#list>
</@c.page>