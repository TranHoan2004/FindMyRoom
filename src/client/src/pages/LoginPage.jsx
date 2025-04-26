import React from 'react';
import LoginForm from '../components/organisms/LoginForm';
import LoginImage from '../components/organisms/LoginImage';
import '../assets/css/main.css';
import '../assets/css/util.css';
import '../assets/css/login.css';

const LoginPage = () => {
    return (
        <div className='container-login100'>
            <div className='wrap-login100'>
                <LoginImage></LoginImage>
                <LoginForm></LoginForm>
            </div>
        </div>
    );
};

export default LoginPage;