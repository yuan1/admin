<#import "../marco/error.ftl" as e>
<@e.error>
<body>
<div class="col-md-12 page-500">
    <div class=" number font-red"> 500</div>
    <div class=" details">
        <h3>Oops! Something went wrong.</h3>
        <p> We are fixing it! Please come back in a while.
            <br></p>
        <p>
            <a href="/main.do" class="btn red btn-outline"> Return home </a>
            <br></p>
    </div>
</div>
</body>
</@e.error>