import React from 'react';
import CheckBox from '../atomics/Checkbox.jsx';

const RememberMeCheckbox = ({
    inputClassName,
    inputId,
    inputName,
    ...rest
}) => {
    return (
        <div className='form-group form-check'>
            <CheckBox
                className={inputClassName}
                id={inputId}
                name={inputName}
                {...rest}
            ></CheckBox>
            <label htmlFor="rememberMe" className="form-check-input">Remember me</label>
        </div>
    );
};

export default RememberMeCheckbox;