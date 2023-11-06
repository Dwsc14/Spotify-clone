<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<header>
    <div class="header-overlay" id="header-overlay"></div>

    <div class="header-popup" id="profilePopup">
        <a href="profile">Profile</a>
        <a href="logout">Log Out</a>
    </div>

    <div class="head-bar">
        <div class="left">
            <nav>
                <div class="for-backward">
                    <i class="bi bi-chevron-left"></i>
                    <i class="bi bi-chevron-right"></i>
                </div>
            </nav>
        </div>

        <div class="right">
            <nav>
                <form action="payment" method="post">
                    <button style="width: 120px; height: 33px; margin-left: 10px">Explore Premium</button>
                </form>
                <c:if test="${sessionScope.User != null}">
                    <i class="bi bi-bell"></i>
                    <div class="user-profile">
                        <a href=""><img src=".${sessionScope.User.getImg()}" alt="" /></a>
                    </div>
                </c:if>
                <c:if test="${sessionScope.User == null}">
                    <form action="login">
                        <button style="width: 80px; height: 33px; margin-left: 10px; background-color: #ffab40; cursor: pointer !important">
                            Login
                        </button>
                    </form>
                </c:if>
            </nav>
        </div>
    </div>
</header>
