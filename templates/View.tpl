
<div th:replace="shared/header"></div>
<!-- form start -->
<div class="col-md-6">
    <form role="form" method="POST">
      <div class="box-body">
        <div class="form-group">
          <label>Name</label>
          <input type="text" name="name" class="form-control">
        </div>
      </div>/>
        <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</div>    
<div th:replace="shared/footer"></div>