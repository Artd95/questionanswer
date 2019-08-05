<#macro form path isregistration isbutton>
    <div class="container">
        ${message?if_exists}
        <form class="form-signin" action=${path} method="post">
            <#--        <div><label> Name : <input type="text" name="username"/> </label></div>-->
            <#--        <div><label> Password: <input type="password" name="password"/> </label></div>-->

            <#if isregistration>
                <h2 class="form-signin-heading" align="center">Registration form</h2>
            <#else>
                <h2 class="form-signin-heading" align="center">Please, sign in!</h2>
            </#if>

            <input type="text" class="form-control" placeholder="Username" name="username" required autofocus>
            <input type="password" class="form-control" placeholder="Password" name="password" required>

            <#if isregistration>
                <input type="email" class="form-control" placeholder="Email" name="email" required>
            <#--        <div><label> E-mail: <input type="email" name="email"/> </label></div>-->
            </#if>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>

            <#if isbutton>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign In</button>
            <#--            <div><input type="submit" value="Sign In"/></div>-->
            <#else>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Registration</button>
            <#--            <div><input type="submit" value="Registration"/></div>-->
            </#if>
        </form>
    </div>
</#macro>

<#--<#macro logout>-->
<#--    <form action="/logout" method="post">-->
<#--        <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
<#--        <input type="submit" value="Sign Out"/>-->
<#--    </form>-->
<#--</#macro>-->

