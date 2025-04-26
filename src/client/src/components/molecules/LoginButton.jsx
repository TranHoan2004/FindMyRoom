import React from 'react';
import Button from '../atomics/Button.jsx';

const LoginButton = ({
    className,
    style = {},
    children,
    ...rest
}) => {
    return (
        <div className='container-login100-form-btn'>
            <Button
                className={className}
                type='submit'
                style={style}
                text={children}
                {...rest}
            >
            </Button>
        </div>
    );
};

export default LoginButton;