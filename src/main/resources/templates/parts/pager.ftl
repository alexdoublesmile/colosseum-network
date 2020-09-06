<#macro pager url page>
    <div class="mt-3">
        <ul class="pagination">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Pages</a>
                <#list 1..page.getTotalPages() as p>
                    <#if (p - 1) == page.getNumber()>
                        <li class="page-item active">
                            <a class="page-link" href="#" tabindex="-1">${p}</a>
                        </li>
                    <#else>
                        <li class="page-item">
                            <a class="page-item" href="${url}?page=${p - 1}&size=${page.getSize()}" tabindex="-1">${p}</a>
                        </li>
                    </#if>
                </#list>
            </li>
        </ul>

        <ul class="pagination">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Elements on the page</a>
                <#list [5, 10, 25, 50] as c>
                    <#if c == page.getSize()>
                        <li class="page-item active">
                            <a class="page-link" href="#" tabindex="-1">${c}</a>
                        </li>
                    <#else>
                        <li class="page-item">
                            <a class="page-item" href="${url}?page=${page.getNumber()}&size=${c}" tabindex="-1">${c}</a>
                        </li>
                    </#if>
                </#list>
            </li>
        </ul>
    </div>
</#macro>