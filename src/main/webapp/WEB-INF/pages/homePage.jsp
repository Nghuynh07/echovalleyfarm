<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:template>

<div class="home_container">
<!-- HEADER -->
<header class="header">
<span class="hamburger"></span>
<h1 class="header_title">echo valley farm</h1>

<div>
<a class="btn_link" href="/about">about us</a>
<a class="btn_link" href="#contact">contact</a>
</div>


</header>


<!-- MAIN -->

<main class="produces">

<div class="produces_wrapper">



<!-- BLUEBERRY -->

<div class="card">

<figure >
<img class="img" src="../img/red_onion.webp" alt="" />
</figure>

<div class="card_wrapper">

<p class="card_title">Red Onion</p>
<p class="seasonal">seasonal</p>
<div class="cart_wrapper">
<p class="card_text">1.99/lb</p>

</div>

</div>
</div>

<!-- RASHSBERRY -->
<div class="card">

<figure >
<img class="img" src="../img/rashsberry.webp" alt="" />
</figure>

<div class="card_wrapper">



<p class="card_title">Rashberry</p>
<p class="seasonal">seasonal</p>

<div class="cart_wrapper">
<p class="card_text">1.99/lb</p>

</div>

</div>
</div>

<!-- APPLES -->

<div class="card">

<figure >
<img class="img" src="../img/apples.webp" alt="" />
</figure>

<div class="card_wrapper">

<p class="card_title">Apples</p>
<p class="seasonal">seasonal</p>

<div class="cart_wrapper">
<p class="card_text">1.99/lb</p>

</div>

</div>
</div>
<!-- ASIAN PEARS -->
<div class="card">

<figure >
<img class="img" src="../img/asian_pears.jpg" alt="" />
</figure>

<div class="card_wrapper">

<p class="card_title">Asian Pears</p>
<p class="seasonal">seasonal</p>

<div class="cart_wrapper">
<p class="card_text">1.99/lb</p>

</div>

</div>
</div>
<!-- BASILS -->

<div class="card">

<figure >
<img class="img" src="../img/basil.webp" alt="" />
</figure>

<div class="card_wrapper">

<p class="card_title">Basils</p>
<p class="seasonal">seasonal</p>

<div class="cart_wrapper">
<p class="card_text">1.99/lb</p>

</div>

</div>
</div>

<!-- BEETS -->
<div class="card">

<figure >
<img class="img" src="../img/beets.webp" alt="" />
</figure>

<div class="card_wrapper">

<p class="card_title">Beets</p>
<p class="seasonal">seasonal</p>

<div class="cart_wrapper">
<p class="card_text">1.99/lb</p>

</div>

</div>
</div>


<!--  BEANS -->

<div class="card">

<figure >
<img class="img" src="../img/beans.webp" alt="" />
</figure>

<div class="card_wrapper">

<p class="card_title">Beans</p>
<p class="seasonal">seasonal</p>

<div class="cart_wrapper">
<p class="card_text">1.99/lb</p>

</div>

</div>
</div>

<!--  DILLS -->

<div class="card">

<figure >
<img class="img" src="../img/dill.webp" alt="" />
</figure>

<div class="card_wrapper">

<p class="card_title">Dills</p>
<p class="seasonal">seasonal</p>

<div class="cart_wrapper">
<p class="card_text">1.99/lb</p>

</div>

</div>
</div>

<!-- PRODUCES END -->
</div>

<a class="see_more_btn" href="/products">SEE MORE</a>
</main>


<!-- GALLERY -->




<!-- CONTACT SECTION -->
<section class="contact" id="contact">

<div class="contact_container">

<div class="contact_infos">
<p class="message">Please leave a message and we will get back to you as soon as we can</p>
<p class="contact_details">Our Contacts</p>
<p>1111 00th maple falls</p>
<p>000-000-0000</p>
</div>


<form action="" method="POST" class="contact_form">

<div class="contact_wrapper">
<label class="contact_label" for="">Name</label>
<input class="contact_input" type="text" />
</div>

<div class="contact_wrapper">
<label class="contact_label" for="">Email</label>
<input class="contact_input" type="text" />
</div>

<div class="contact_wrapper">
<label class="contact_label" for="">Message</label>
<input class="input contact_input" type="text" />
</div>

</form>



</div>

</section>
</div>

</t:template>
