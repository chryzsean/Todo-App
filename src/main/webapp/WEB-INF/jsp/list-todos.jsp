<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
    <div class="container">


    <!--        <div>Welcome Back ${name}!</div>-->
        <!--    <div>Your Todos are: ${todos}!</div>-->
        <!--    <div>Your Password: ${password}</div>-->
        <div>Your Todos Are:</div>
            <table class="table">
                <thead>
    <!--            <th>id</th>-->
                <th>Description</th>
                <th>Target Date</th>
                <th>Status</th>
                <th></th>
                <th></th>
                </thead>
                <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
    <!--                    <td>${todo.id}</td>-->
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                        <td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a>
                        <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add Todo</a>
    </div>
<%@ include file="common/footer.jspf"%>