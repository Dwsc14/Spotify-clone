<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<header>
    <div class="head-bar">
        <div class="left">
            <nav>
                <div class="for-backward">
                    <i class="bi bi-chevron-left"></i>
                    <i class="bi bi-chevron-right"></i>
                </div>
                <div id="myDiv" class="input-search">
                    <form action="search" method="post">
                        <i class="input-icon bi bi-search"></i>
                        <input type="text" name="txtSearch" id="myInput" placeholder="Search Music...">
                    </form>
                </div>
            </nav>
        </div>

        <div class="right">
            <nav>
                <button>Explore Premium</button>
                <i class="bi bi-bell"></i>
                <div class="user-profile">
                    <img src="static/img/user.jpg" alt="">
                </div>
            </nav>
        </div>
    </div>
</header>