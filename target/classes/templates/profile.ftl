<#import "Macros/list_questions.ftl" as commonFile>
<@commonFile.list_questions>

        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
        <link href="form-validation.css" rel="stylesheet">
    <body class="bg-light">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div class="container">
        <div class="py-5 text-center">
            <img class="d-block mx-auto mb-4" src="/docs/4.3/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
<#--            <h2>Profile <i><b color="CadetBlue">@${username}</i></b></h2>-->
        </div>

        <div class="row">
            <div class="col-md-4 order-md-2 mb-4">
                <h4 class="d-flex justify-content-between align-items-center mb-3">
                    <span class="text-muted">Avatar</span>
                </h4>
                <ul class="list-group mb-3">
<#--                    <li class="list-group-item d-flex justify-content-between lh-condensed">-->
<#--                        <div>-->
<#--                            <h6 class="my-0">Product name</h6>-->
<#--                            <small class="text-muted">Brief description</small>-->
<#--                        </div>-->
<#--                        <span class="text-muted">$12</span>-->
                    </li>
<#--                    <li class="list-group-item d-flex justify-content-between lh-condensed">-->
<#--                        <div>-->
<#--                            <h6 class="my-0">Second product</h6>-->
<#--                            <small class="text-muted">Brief description</small>-->
<#--                        </div>-->
<#--                        <span class="text-muted">$8</span>-->
<#--                    </li>-->
<#--                    <li class="list-group-item d-flex justify-content-between lh-condensed">-->
<#--                        <div>-->
<#--                            <h6 class="my-0">Third item</h6>-->
<#--                            <small class="text-muted">Brief description</small>-->
<#--                        </div>-->
<#--                        <span class="text-muted">$5</span>-->
<#--                    </li>-->
<#--                    <li class="list-group-item d-flex justify-content-between bg-light">-->
<#--                        <div class="text-success">-->
<#--                            <h6 class="my-0">Promo code</h6>-->
<#--                            <small>EXAMPLECODE</small>-->
<#--                        </div>-->
<#--                        <span class="text-success">-$5</span>-->
<#--                    </li>-->
<#--                    <li class="list-group-item d-flex justify-content-between">-->
<#--                        <span>Total (USD)</span>-->
<#--                        <strong>$20</strong>-->
<#--                    </li>-->
                </ul>

<#--                <form class="card p-2">-->
<#--                    <div class="input-group">-->
<#--                        <input type="text" class="form-control" placeholder="Promo code">-->
<#--                        <div class="input-group-append">-->
<#--                            <button type="submit" class="btn btn-secondary">Redeem</button>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </form>-->
            </div>
            <div class="col-md-8 order-md-1">
                <h4 class="mb-3">Information</h4>
                <form class="needs-validation" novalidate>
                    <div class="row">
                        <div class="col-md-6 mb-3">
                            <label for="firstName">First name</label>
                            <label class="form-control">${firstname!}</label>
                        </div>
                        <div class="col-md-6 mb-3">
                            <label for="lastName">Last name</label>
                            <label class="form-control">${lastname!}</label>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="email">Email</label>
                        <label class="form-control">${email!}</label>
                    </div>

                    <div class="mb-3">
                        <label for="address">Address</label>
                        <label class="form-control">${address!}</label>
                    </div>

                    <div class="row">
                        <div class="col-md-5 mb-3">
                            <label for="country">Country</label>
                            <label class="form-control">${country!}</label>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label for="state">City</label>
                            <label class="form-control">${city!}</label>
                        </div>
                        </div>
                    <div align="center"><a href="/questionList"><h5><-- Back to question list</h5></a></div>
                </form>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
    <script src="form-validation.js"></script></body>
    </html>

</@commonFile.list_questions>