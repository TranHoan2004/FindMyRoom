import React from 'react';

const Input = ({
    inputClassName,
    inputId,
    inputPlaceholder,
    isRequired,
    type = 'text',
    name
}) => {
    return (
        <input
            className={inputClassName}
            id={inputId}
            placeholder={inputPlaceholder}
            required={isRequired ? 'required' : ''}
            type={type}
            name={name}
        ></input>
    );
};

export default Input;