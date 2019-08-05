<#import "Macros/list_questions.ftl" as commonFile>
<@commonFile.list_questions>
<form  action="/upload" method="POST" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    File to upload: <input type="file" name="file"/> Name: <input type="text" name="name"/>
    <button type="submit" value="Upload"> Press here to upload the file!</button>
</form>

<#--    <div>-->
<#--        <form method="POST" enctype="multipart/form-data" action="/upload">-->
<#--            <table>-->
<#--                <tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>-->
<#--                <tr><td></td><td><input type="submit" value="Upload" /></td></tr>-->
<#--            </table>-->
<#--        </form>-->
<#--    </div>-->
</@commonFile.list_questions>