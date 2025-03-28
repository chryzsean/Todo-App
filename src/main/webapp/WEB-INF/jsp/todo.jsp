<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">


    <!--        <div>Welcome Back ${name}!</div>-->
    <!--    <div>Your Todos are: ${todos}!</div>-->
    <!--    <div>Your Password: ${password}</div>-->
    <h1>Enter Todo Details</h1>
    <form:form method="post" modelAttribute="todo">

        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input path="description" cssClass="form-control"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input path="targetDate" cssClass="form-control"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>

        <form:input type="hidden" path="id"/>

        <form:input type="hidden" path="done"/>

        <input type="submit" class="btn btn-success"/>
    </form:form>


</div>

<%@ include file="common/footer.jspf"%>

<script type="text/javascript">
    $('#targetDate').datepicker({
    format: 'yyyy-mm-dd'
});

</script>

