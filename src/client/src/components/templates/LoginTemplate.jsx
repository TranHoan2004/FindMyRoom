import React from 'react';
import LoginForm from '../organisms/LoginForm';
import '../../assets/css/main.css';
import '../../assets/css/util.css';
import '../../assets/css/login.css';

const LoginTemplate = () => {
    return (
        <div className='container-login100'>
            <div className='wrap-login100'>
                <LoginForm></LoginForm>
            </div>
        </div>
    );
};

export default LoginTemplate;