<div class="cards-columns">
    <#list messages as message>
        <div class="card my-3">
            <#if message.filename??>
                <img src="/img/${message.filename}" class="card-img-top">
            </#if>
            <div class="m-2">
                <span>${message.text}</span>
                <i>${message.tag}</i>
            </div>
            <div class="card-footer text-muted">
                <strong>${(message.author.username)!"&lt;none&gt;"}</strong>
            </div>
        </div>
    <#else>
        No message
    </#list>
</div>