{
    "headData":[
    <#if table.fields?? &&(table.fields?size>0)>
    <#list table.fields as field>
        <#if field.comment!?length gt 0>
            {
                "title": "${field.comment}",
                "prop":"${field.propertyName}"
            }<#if field_has_next>,</#if>
        </#if>
    </#list>
    </#if>
    ],
    "searchData":[
    <#if table.fields?? &&(table.fields?size>0)>
    <#list table.fields as field>
        <#if field.comment!?length gt 0>
            {
                "title": "${field.comment}",
                "prop":"${field.propertyName}",
                "type":${field.type?replace('\\D',"",'r')?number}
            }<#if field_has_next>,</#if>
        </#if>
    </#list>
    </#if>
    ]
}