import React from 'react';

const Input = ({
    inputClassName,
    inputId,
    inputPlaceholder,
    isRequired,
    type = 'text',
    name,
    value,
    onChange
}) => {
    return (
        <input
            className={inputClassName}
            id={inputId}
            placeholder={inputPlaceholder}
            required={isRequired ? 'required' : ''}
            type={type}
            name={name}
            value={value}
            onChange={onChange}
        ></input>
    );
};

export default Input;