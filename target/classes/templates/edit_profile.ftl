<#import "Macros/list_questions.ftl" as commonFile>
<@commonFile.list_questions>

    <form  action="/edit_profile" method="post">
        <div><label> First name: <input type="text" name="firstname" value="${user.firstnamel!}"/> </label></div>
        <div><label> Last name: <input type="text" name="lastname" value="${user.lastname!}"/> </label></div>
        <div><label> Email: <input type="text" name="email" value="${user.email!}"/> </label></div>
        <div><label> Username : <input type="text" name="username" value="${user.username}"/> </label></div>
        <div><label> Password: <input type="text" name="password" value="${user.password!}"/> </label></div>
        <div><label> Email: <input type="text" name="email" value="${user.email!}"/> </label></div>
        <div><label> Address: <input type="text" name="address" value="${user.address!}"/> </label></div>
        <div><label> Country: <input type="text" name="country" value="${user.country!}"/> </label></div>
        <div><label> City: <input type="text" name="city" value="${user.city!}"/> </label></div>
        <div><input type="submit" value="Save data"/></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
    </form>

    <form action="/upload" >
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="submit" value="upload"/>
        </form>

</@commonFile.list_questions>