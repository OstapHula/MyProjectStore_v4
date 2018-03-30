<%@ include file="/WEB-INF/taglib.jsp" %>

<div class="row">
	<div class="col-md-5 profile-img">
		<a href="#" data-toggle="modal" data-target="#photoModal" class="float-md-right">
			<img src="data:image/png; base64, ${productModel.}" alt="image profile"/>
			<i class="fas fa-search-plus fa-2x"></i>
		</a>
	</div>
	<div class="col-md-7">
		<h2>${userProfile.role.role} profile</h2>
		<hr>
		<ul>
			<li>Name: ${userProfile.firstName} ${userProfile.lastName}</li>
			<li>Age: ${userProfile.birthday.getYear}</li>
			<li>Email: ${userProfile.email}</li>
			<li>Address: ${userProfile.address}</li>
			<li>Telephone: ${userProfile.telephone}</li>
			<li>Birthday: ${userProfile.birthday}</li> 
		</ul>
	</div>
</div>

<!-- @NotEmpty private String name;
        @NotEmpty private BigDecimal price;
        @NotEmpty private String description;
        private MultipartFile file;
        private ProductStyle style;
        private MaterialStrap materialStrap;
        private MaterialBody materialBody;
	private FaseType faseType;
	private FaseColor faseColor;
	private int weight;
	private int waterproof;
	private String glass;
	private int widthStrap;
	private int diametrBody;
	private int thicknessBody; -->