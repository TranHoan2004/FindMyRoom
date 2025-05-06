import React from 'react';
import InputField from '../molecules/InputField.jsx';
import { faEnvelope, faLock } from '@fortawesome/free-solid-svg-icons';
import LoginButton from '../molecules/LoginButton.jsx';
import fblogo from '/src/assets/images/Facebook_Logo_(2019).png';
import googlelogo from '/src/assets/images/Google.png';
import CheckBox from '../atomics/Checkbox.jsx';
import { useState } from 'react';


const LoginForm = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleData = (e) => {
        e.preventDefault();
        // setEmail('hehe: ');
        // setPassword('hoho: ');
        alert(`Email: ${email}, Password: ${password}`);
    }

    const handleEmailChange = (e) => {
        setEmail(e.target.value);
    }
    const handlePasswordChange = (e) => {
        setPassword(e.target.value);
    }
    return (
        <form className='form-signin' onSubmit={handleData}>
            <span className="login100-form-title">
                Login in here
            </span>
            <InputField
                inputClassName='input100 form-control'
                inputId='inputEmail'
                inputPlaceholder='Username'
                isRequired={true}
                name='username'
                icon={faEnvelope}
                value={email}
                onChange={handleEmailChange}
            ></InputField>
            <InputField
                inputClassName='input100 form-control'
                inputId='inputPassword'
                inputPlaceholder='Password'
                isRequired={true}
                type='password'
                name='password'
                icon={faLock}
                value={password}
                onChange={handlePasswordChange}
            ></InputField>

            {/* Remember me */}
            <div className='form-group form-check'>
                <CheckBox
                    className='form-check-input'
                    id='rememberMe'
                    name='remember'
                    value='1'
                ></CheckBox>&nbsp;
                <label htmlFor="rememberMe" className="form-check-input">Remember me</label>
            </div>

            {/* Login button */}
            <LoginButton
                className='login100-form-btn'
                type='submit'
                children={'Login'}
                style={{ background: 'rgb(87, 184, 70)' }}
            ></LoginButton>

            <hr style={{ marginTop: '10px' }} />
            <p>Or sign in with</p>

            {/* Facebook and Google */}
            <LoginButton
                className='login100-form-btn'
                type='submit'
                style={{ background: 'rgb(255, 255, 255)', color: 'rgb(0, 34, 255)', border: '1px solid black' }}
                children={
                    <>
                        <img src={fblogo} alt={'Facebook'} style={{ width: '20px', height: '20px' }}></img>&nbsp;
                        Facebook
                    </>
                }
            ></LoginButton>
            <LoginButton
                className='login100-form-btn'
                type='submit'
                style={{ background: 'rgb(255, 255, 255)', color: 'rgb(255, 0, 0)', border: '1px solid black' }}
                children={
                    <>
                        <img src={googlelogo} alt={'Google'} style={{ width: '20px', height: '20px' }}></img>&nbsp;
                        Google
                    </>
                }
            ></LoginButton>
        </form>
    );
};

export default LoginForm;