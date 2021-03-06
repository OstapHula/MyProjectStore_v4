<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="container edit">
    <div class="row">

	<%@ include file="/WEB-INF/fragments/_leftnav.jsp" %>

      <div class="col-lg-9">
      	<form:form 
	      		action="/user/edit" 
	      		modelAttribute="editUserModel" 
	      		method="POST" 
	      		enctype="multipart/form-data">
			<div class="form-group">
				<form:errors path="*" cssClass="error"/>
				
				<c:if test="${error != null}">
					<span class="error">${error}</span>
				</c:if>
			</div>
			<div class="form-group">
              <div class="form-group row">
	          <label class="col-sm-2 col-form-label">First name: </label>
		         <div class="col-sm-10">
		           <form:input path="firstName" cssClass="form-control" title="First name" />
		         </div>
		      </div>
		      
		      <div class="form-group row">
		        <label class="col-sm-2 control-label">lastName: </label>
		        <div class="col-sm-10">
		          <form:input path="lastName" cssClass="form-control" title="last name" />
		      	</div>
		      </div>
		        
		      <div class="form-group row">
		         <label class="col-sm-2 control-label">Address: </label>
		         <div class="col-sm-10">
		           <form:input path="address" cssClass="form-control" title="Address" />
		         </div>
		      </div>
		        
		      <div class="form-group row">
		         <label class="col-sm-2 control-label">Telephone: </label>
		         <div class="col-sm-10">
		           <form:input path="telephone" cssClass="form-control" title="Telephone" />
		         </div>
		      </div>
	        
		      <div class="form-group row">
		         <label class="col-sm-2 control-label">Birthday: </label>
		         <div class="col-sm-10">
		           <form:input path="birthday" cssClass="form-control" title="Birthday" />
		         </div>
		      </div>
	        
		      <div class="form-group row">
		         <label class="col-sm-2 control-label">E-mail address</label>
		         <div class="col-sm-10">
		           <form:input path="email" cssClass="form-control" title="E-mail address" disabled="true" />
		         </div>
		      </div>
		      
		      <div class="form-group row">
		         <label class="col-sm-2 control-label">Upload image: </label>
		         <div class="col-sm-10">
		           <form:input path="file" type="file"/>
		         </div>
		      </div>
		      
			  <div class="row">
				 <div class="col"><input type="submit" class="btn btn-success btn-block" value="Save change"></div>
			  </div>
			</div>
		</form:form>
     </div>
   </div>
 </div>
