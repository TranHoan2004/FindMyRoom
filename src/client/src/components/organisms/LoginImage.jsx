import { React, useEffect } from 'react';
import image from '/src/assets/images/img-01.png';

const LoginImage = () => {
    useEffect(() => {
        // 1. Tải jQuery
        const jqueryScript = document.createElement('script');
        jqueryScript.src = 'https://code.jquery.com/jquery-3.6.0.min.js';
        jqueryScript.async = true;
        document.body.appendChild(jqueryScript);

        // 2. Khi jQuery load xong, mới load tilt
        jqueryScript.onload = () => {
            const tiltScript = document.createElement('script');
            tiltScript.src = '/src/assets/vendor/tilt/tilt.jquery.min.js';
            tiltScript.async = true;
            document.body.appendChild(tiltScript);

            tiltScript.onload = () => {
                if (window.jQuery) {
                    window.jQuery('.js-tilt').tilt({
                        scale: 1.1,
                    });
                }
            };
        };

        //     // Cleanup khi unmount
        return () => {
            document.body.removeChild(jqueryScript);
        };
    }, []);
    return (
        <div className="login100-pic js-tilt" data-tilt>
            <img src={image} alt="IMG"></img>
        </div>
    );
};

export default LoginImage;