import React from 'react';

const OAuthButton = ({
    className,
    text,
    style = {},
    src,
    alt,
    imgStyle,
    ...rest
}) => {
    return (
        <div className='container-login100-form-btn'>
            <button
                className={className}
                type='submit'
                style={style}
                {...rest}
            >
                <img src={src} alt={alt} style={imgStyle} />&nbsp;
                {text}
            </button>
        </div>
    );
};

export default OAuthButton;