import React from 'react';
import Input from '../atomics/Input.jsx';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

const InputField = ({
    forName,
    inputClassName,
    inputId,
    inputPlaceholder,
    isRequired,
    type = 'text',
    name,
    icon
}) => {
    return (
        <div className='wrap-input100 validate-input'>
            <label htmlFor={forName}>
                <Input
                    inputClassName={inputClassName}
                    inputId={inputId}
                    inputPlaceholder={inputPlaceholder}
                    isRequired={isRequired}
                    type={type}
                    name={name}
                ></Input>
            </label>
            <span className='focus-input100'></span>
            <span className='symbol-input100'>
                <FontAwesomeIcon icon={icon}></FontAwesomeIcon>
            </span>
        </div>
    );
};

export default InputField;