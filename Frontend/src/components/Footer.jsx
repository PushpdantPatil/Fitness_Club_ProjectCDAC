import React from 'react';
// import { FaFacebook, FaTwitter, FaInstagram, FaSnapchat } from 'react-icons/fa';
// import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
// import {
//     faYoutube,
//     faFacebook,
//     faTwitter,
//     faInstagram
// } from "@fortawesome/free-brands-svg-icons";

import { Link } from 'react-router-dom';
const Footer = () => {
    const currentYear = new Date().getFullYear();
    return (
        <footer className="footer">
            <div className="footer-container">
                <strong className="footer-subheading">
                    <Link to={"/login"} href="/login">
                    <strong className="footer-subheading">JOIN US NOW </strong>
                    </Link>
                    
                </strong>
                {/* <div class="social-container">
                    <a href="https://www.youtube.com/"
                        target='blank'
                        className="youtube social">
                        <FontAwesomeIcon icon={faYoutube} size="4x" />
                    </a>
                    <a href="https://www.facebook.com/Prime-Fit-125463350053201"
                        target='blank'
                        className="facebook social">
                        <FontAwesomeIcon icon={faFacebook} size="4x" />
                    </a>
                    <a href="https://www.twitter.com/PrimeFit8"
                        target='blank'
                        className="twitter social">
                        <FontAwesomeIcon icon={faTwitter} size="4x" />
                    </a>
                    <a href="https://www.instagram.com/prime_fit8"
                        target='blank'
                        className="instagram social">
                        <FontAwesomeIcon icon={faInstagram} size="4x" />
                    </a>
                </div> */}



                <div className="footer-sub location">
                    <strong className="footer-subheading">Location</strong>
                    <strong className="footer-desc">216, Main Road, Sangli, IN-416416</strong>
                    <strong className="footer-desc">Monday Through Thursday (6AM to 8PM)</strong>
                    <strong className="footer-desc">Friday (6AM to 6PM)</strong>
                </div>
                <div className="alt-location">
                    <strong className="footer-subheading">Location</strong>
                    <span className="footer-desc">
                        216, Main Road, Sangli, IN-416416
                        <br />
                        Monday through Thursday (6AM to 8Pm). Friday (6AM to 6Pm)
                    </span>
                </div>

                <div className="wrapper">
                    <div className="footer-sub">
                        <strong className="footer-subheading">Community</strong>
                        <small>Health Awareness</small>
                        <small>Sunday Yoga Camps</small>
                        <small>Blood Donation Camps</small>
                    </div>

                    <div className="footer-sub">
                        <strong className="footer-subheading">Services</strong>
                        <small>Personal Trainer</small>
                        <small> Nutriotional Guidances</small>
                        <small> Weight Loss Program</small>
                    </div>
                    <div className="footer-sub">
                        {/* <strong className="footer-subheading">
                            <a href="/privacypolicy">Privacy Policy</a></strong> */}

                        <Link to={"/privacypolicy"} href="/privacypolicy">
                            <strong className="footer-subheading">Privacy Policy </strong>
                        </Link>
                        <Link to={"/termsofservice"} href="/termsofservice">
                            <strong className="footer-subheading">Terms of Service </strong>
                        </Link>

                    </div>
                    
                </div>

                <span className="footer-subheading footer-copy">&copy;&nbsp;FitnessClub {currentYear}</span>
            </div>
        </footer>
    )
}

export default Footer;
// export default function SocialFollow() {
//     return (
//       <div class="social-container">
//         <h3>Social Follow</h3>
//       </div>
//     );
//   }