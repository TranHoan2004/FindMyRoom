import React from 'react';
import InputField from '../molecules/InputField.jsx';
import { faEnvelope, faLock } from '@fortawesome/free-solid-svg-icons';
import RememberMeCheckbox from '../molecules/RememberMeCheckbox.jsx';
import LoginButton from '../molecules/LoginButton.jsx';
import fblogo from '/src/assets/images/Facebook_Logo_(2019).png';
import googlelogo from '/src/assets/images/Google.png';
import OAuthButton from '../molecules/OAuthButton.jsx';

const LoginForm = () => {
    return (
        <div className='form-login'>
            <span className="login100-form-title">
                Login in here
            </span>
            <InputField
                forName='inputEmail'
                inputClassName='input100 form-control'
                inputId='inputEmail'
                inputPlaceholder='Username'
                isRequired={true}
                name='username'
                icon={faEnvelope}
            ></InputField>
            <InputField
                forName='inputPassword'
                inputClassName='input100 form-control'
                inputId='inputPassword'
                inputPlaceholder='Password'
                isRequired={true}
                type='password'
                name='password'
                icon={faLock}
            ></InputField>

            <RememberMeCheckbox
                inputClassName='form-check-input'
                inputId='rememberMe'
                inputName='remember'
                value='1'
            ></RememberMeCheckbox>

            {/* Login button */}
            <LoginButton
                className='login100-form-btn'
                type='submit'
                text='Login'
                style={{ background: 'rgb(87, 184, 70)' }}
            ></LoginButton>

            <hr />
            <p>Or sign in with</p>

            {/* Facebook and Google */}
            <OAuthButton
                className='login100-form-btn'
                type='submit'
                style={{ background: 'rgb(255, 255, 255)', color: 'rgb(0, 34, 255)', border: '1px solid black' }}
                text={'Facebook'}
                src={fblogo}
                alt={'Facebook'}
                imgStyle={{ width: '20px', height: '20px' }}
            ></OAuthButton>
            <OAuthButton
                className='login100-form-btn'
                type='submit'
                style={{ background: 'rgb(255, 255, 255)', color: 'rgb(255, 0, 0)', border: '1px solid black' }}
                text={'Google'}
                src={googlelogo}
                alt={'Google'}
                imgStyle={{ width: '20px', height: '20px' }}
            ></OAuthButton>
        </div>
    );
};

export default LoginForm;