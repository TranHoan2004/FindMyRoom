import React from 'react';

const Button = ({
    className,
    text,
    ...rest
}) => {
    return (
        <button className={className} {...rest}>
            {text}
        </button>
    );
};

export default Button;