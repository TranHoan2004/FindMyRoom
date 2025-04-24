import React from 'react';

const Checkbox = ({
    className,
    id,
    name,
    ...rest
}) => {
    return (
        <input 
            className={className}
            id={id}
            type='checkbox'
            {...rest}
            name={name}
        ></input>
    );
};

export default Checkbox;