import React from 'react';

const Button = ({
    className,
    type = 'button',
    children,
    ...rest
}) => {
    return (
        <button
            className={className}
            type={type}
            {...rest}>
            {children}
        </button>
    );
};

export default Button;