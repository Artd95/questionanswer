<#import "Macros/list_questions.ftl" as commonFile>
<@commonFile.list_questions>

    <form class="form-inline my-2 my-lg-0" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input class="form-control mr-sm-2" type="text" name="text"
               placeholder="You question                                    ">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit"> Ask</button>
    </form>
    </div>
    <div class="my-3 p-3 bg-white rounded shadow-sm">
        <h6 class="border-bottom border-gray pb-2 mb-0">REZULT</h6>
        <#list questions as question>
            <div class="media text-muted pt-3">
                <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg"
                     preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32">
                    <title>Placeholder</title>
                    <rect width="100%" height="100%" fill="#007bff"/>
                    <text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text>
                </svg>
                <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                    <strong class="d-block text-gray-dark">@${question.username}</strong>
                    ${question.text}
                </p>
                <a href="/questionList/${question.id}">See all</a>
            </div>
        <#else>
            No questions
        </#list>
    </div>
</@commonFile.list_questions>