import { Link } from "react-router-dom"
import { useState } from "react"
import { IoEyeOffOutline, IoEyeOutline } from "react-icons/io5";

const onSubmit =()=>{

}
const Login = () => {
  const [showPassword, setShowPassword]= useState(false)
  return (
    <div className=" flex flex-col gap-12 justify-center min-w-[400px] ">
      <div className=" flex justify-center">

        <img 
        src="/images/logo.png" 
        alt="Logo Image"
        />
      </div>

      <form onSubmit={onSubmit}>
      <div className=" flex flex-col gap-8">
        <div className="flex flex-col gap-2">
          <label className=" font-medium font-inter text-dark-4 text-[16px]">Email Address</label>
          <input 
            type="text" 
            name="email"
            placeholder="johndoe@gmail.com"
            className="border-2 border-dark-3 rounded-lg bg-secondary focus:border-dark-3 w-full px-3 py-3  text-gray-2"
            />

        </div>
        <div className="flex flex-col gap-2">
          <div className=" flex w-full justify-between">
            <label className=" font-medium font-inter text-dark-4 text-[16px]">Password</label>
            <Link 
            to="/forgot-password"
            className=" text-primary-1 font-inter font-medium text-[16px]"
            >
                  Forgot Password?
            </Link>
          </div>
          <div className="relative">
      <input
        type={showPassword ? "text" : "password"}
        name="password"
        className="border-2 border-dark-3 rounded-lg bg-secondary focus:border-dark-3 w-full px-3 py-3 text-gray-2 pr-10"
        placeholder="Enter your password"
      />

      <div 
        className="absolute right-3 top-1/2 transform -translate-y-1/2 cursor-pointer"
        onClick={() => setShowPassword(!showPassword)}
      >
        {showPassword ? (
          <IoEyeOffOutline className="text-primary-1" size={24} />
        ) : (
          < IoEyeOutline className="text-gray-2" size={24} />
        )}
      </div>
    </div>

         </div>
         <div className=" flex gap-4 items-center">
          <input type="checkbox" className=" h-5 w-5 text-white accent-primary-1 cursor-pointer"/>
          <p className=" font-inter text-[16px] text-dark-4">Keep me signed in</p>
         </div>
         <button className=" font-semibold text-[16px] leading-6 font-inter bg-primary-1 rounded-lg text-white px-3 py-3">Login</button>

         <div className=" flex gap-3 justify-center items-center">
          <hr className=" bg-gray-2 h-[2px] w-[100px] opacity-20"/>
          <p className=" text-gray-3 font-inter text-[14px] leading-5">or sign in with</p> 
          <hr className="bg-gray-2 h-[2px] w-[100px] opacity-20"/>
         </div>

         <button className=" bg-light-gray px-6 py-3 flex justify-center items-center rounded-lg text-gray-2 text-[16px] font-inter font-normal ">
          <img 
          src="/icons/Google.svg" 
          alt="Google icon"
          width={24}
          height={24}
          className=" mr-4"
          />

       Continue with Google
         </button>


         <Link 
         to="/auth/signup"
          className="text-primary-1 font-semibold text-lg font-inter text-center mt-2"
         >
           Create an account
         </Link>
        </div>
      </form>
    </div>
  )
}

export default Login
