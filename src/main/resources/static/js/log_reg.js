/**
 * 
 */
 
 'use strict';
 
const newUser = document.querySelector('.new_user');
const loginContainer = document.querySelector('.login_wrapper');
const registerContainer = document.querySelector('.register_wrapper');
const profileBtn = document.querySelector('.profile_btn');
const personalForm = document.querySelector('.personal_form');
const hamburger = document.querySelector('.hamburger');
const navbar = document.querySelector('.navbar');

newUser.addEventListener('click', function(){
	loginContainer.classList.add('hidden');
	registerContainer.classList.remove('hidden');
})
