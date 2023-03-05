import React from 'react'
import { Link } from "react-router-dom";
import Logout from '../../screens/common/Logout';
import {useSelector} from 'react-redux';
import {useHistory} from 'react-router-dom';

const  LocalAdminPage=()=> {


  const history=useHistory();
  const isSignin = useSelector((state) => state.isSignin);

  console.log("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
  console.log(isSignin.user);
  // console.log("yyyyy"+isSignin.user.branch.id);
  if(isSignin.status === false){
    alert('please signin first!!')
    history.push('/login')
  }
  return (
    <div className="privacydiv">
        <Logout/>
        <div align="center" className="admin-page">
      Local Admin Page
      </div>
      <hr/>
        <hr/>
        <hr/>
        <hr/>
        <hr/>
        <hr/>

        <button className="block"
        onClick={()=>{history.push('/mybranchpage',{branchId:isSignin.user.branch.id})}}>Branch Page
        </button>

        {/* <Link to="/brancheslist"> <a className="block" href=" ">Branches</a> </Link> */}


        <button className="block"
        onClick={()=>{history.push('/packageslist',{branchId:isSignin.user.branch.id})}}>Packages
        </button>

        <hr/>
        <hr/> 
        <hr/>
        


    </div>
  )
}
export default LocalAdminPage