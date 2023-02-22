import React from "react";
import { Link } from "react-router-dom";
import Logout from '../../screens/common/Logout';
import {useSelector} from 'react-redux';
import {useHistory} from 'react-router-dom';
//import './MemberPage.css';
//import UserProfile from './UserProfile';
//import Card from './Card';

const MemberPage = () => {
  // const [name, setName] = useState("your name");
  // const [job, setJob] = useState("Job Title");
  // const [about, setAbout] = useState("About job details for  your name Google Fonts is a library of 1,364 open sourcy");

  const history=useHistory();
  const isSignin = useSelector((state) => state.isSignin);

  console.log("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  console.log(isSignin.user);

  if(isSignin.status === false){
    alert('please signin first!!') 
    history.push('/login')
  }
  
  return (
    <div className="privacydiv">
      <Logout />
      <div align="center" className="admin-page">
        MemberPage
      </div>
      <hr />
      <hr />
      <hr />
      <hr />
      <hr />
      <hr />
      {/* <UserProfile/> */}

      <Link to="/trainers">   <a className="block" href=" ">          Trainers        </a>      </Link>

      <Link to="/branches">   <a className="block" href=" ">          Branches        </a>      </Link>      
        
      <Link to="/packages"><a className="block" href=" ">          Packages        </a>      </Link>

      <Link to="/profilemember"><a className="block" href=" ">          Profile        </a>      </Link>

      {/* <div>

          <Card 
          // name={ name } job={ job } about={ about }
          />
        </div> */} 
    </div>
  );
};
export default MemberPage;
