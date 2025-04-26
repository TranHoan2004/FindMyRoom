import React from 'react';
import Input from '../atomics/Input.jsx';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

const InputField = ({
    inputClassName,
    inputId,
    inputPlaceholder,
    isRequired,
    type = 'text',
    name,
    icon,
    onChange,
    value
}) => {
    return (
        <div className='wrap-input100 validate-input'>
            <Input
                inputClassName={inputClassName}
                inputId={inputId}
                inputPlaceholder={inputPlaceholder}
                isRequired={isRequired}
                type={type}
                name={name}
                onChange={onChange}
                value={value}
            ></Input>
            <span className='focus-input100'></span>
            <span className='symbol-input100'>
                <FontAwesomeIcon icon={icon}></FontAwesomeIcon>
            </span>
        </div>
    );
};

export default InputField;