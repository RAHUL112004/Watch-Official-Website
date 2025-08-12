<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Watch Store</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/home.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" />
</head>
<body>

    <!-- Account Panel Toggle (Hidden Checkbox) -->
    <input type="checkbox" id="accountToggle" hidden />

    <!-- Overlay to close panel -->
    <label for="accountToggle" class="overlay"></label>

    <!-- Account Panel Sliding from Right -->
    <div class="account-panel">
        <ul>
			<li><a href="${pageContext.request.contextPath}/registerPage">Register</a></li>
			           <li><a href="${pageContext.request.contextPath}/loginPage">Login</a></li>
			           <li><a href="${pageContext.request.contextPath}/cartPage">Cart</a></li>
			           <li><a href="#">Track Order</a></li>
			           <li><a href="#">Rewards</a></li>
        </ul>
    </div>

    <!-- Banner Image -->
    <div class="banner-container">
        <img id="bannerImage" src="${pageContext.request.contextPath}/image/homeimage1.jpg" alt="Banner Image" />
    </div>

    <div class="spacer"></div>

    <!-- Top Bar -->
    <div class="top-bar">
        <div class="logo">R</div>

        <div class="search-container">
            <input type="text" class="search-box" placeholder="Search for watches..." />
        </div>

        <div class="icons">
            <!-- Use Label to Toggle Checkbox -->
            <label for="accountToggle" class="icon-set" style="cursor: pointer;">
                <i class="fas fa-user"></i>
                <div>Account</div>
            </label>
            <div class="icon-set">
                <i class="fas fa-shopping-cart"></i>
                <div>Cart</div>
            </div>
            <div class="icon-set">
                <i class="fas fa-truck"></i>
                <div>Track Order</div>
            </div>
        </div>
    </div>

    <!-- Products -->
    <div class="products">
        <c:forEach var="w" items="${watch}">
            <div class="product-card">
                <img src="${pageContext.request.contextPath}${w.imageUrl}" alt="${w.name}" class="product-image" />
                <div class="product-name">${w.name}</div>
                <div class="product-brand">${w.brand}</div>
                <div class="product-price">$${w.price}</div>
                <div class="product-description">${w.description}</div>
            </div>
        </c:forEach>
    </div>

    <!-- Banner Auto-Change Script -->
    <script>
        const images = [
            "${pageContext.request.contextPath}/image/homeimage1.jpg",
            "${pageContext.request.contextPath}/image/homeimage2.jpg",
            "${pageContext.request.contextPath}/image/homeimage3.jpg"
        ];
        let currentIndex = 0;
        const bannerImage = document.getElementById('bannerImage');
        setInterval(() => {
            currentIndex = (currentIndex + 1) % images.length;
            bannerImage.src = images[currentIndex];
        }, 8000);
    </script>

</body>
</html>