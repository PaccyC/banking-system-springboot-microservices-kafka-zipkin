import { useState } from "react"
import { IoEyeOffOutline, IoEyeOutline } from "react-icons/io5"
import { Link } from "react-router-dom"


const onSubmit =()=>{

}
const Signup = () => {
  const [showPassword, setShowPassword]= useState(false)

  return (
    <div className=" flex flex-col gap-12 justify-center py-16  ">
    <div className=" flex justify-center">

      <img 
      src="/images/logo.png" 
      alt="Logo Image"
      />
    </div>

    <h3 className=" text-center text-dark-1 font-inter font-semibold text-2xl">Create an account</h3>

    <form onSubmit={onSubmit}>
    <div className=" flex flex-col gap-8">
      <div className=" w-full grid gap-4 grid-cols-2">
        <div className="flex flex-col gap-2">
          <label className=" font-medium font-inter text-dark-4 text-[16px]">First Name</label>
          <input 
            type="text" 
            name="firstname"
            className="border-2 border-dark-3 rounded-lg bg-secondary focus:border-dark-3 w-full px-3 py-3  text-gray-2"
            />

        </div>
        <div className="flex flex-col gap-2">
          <label className=" font-medium font-inter text-dark-4 text-[16px]">Last Name</label>
          <input 
            type="text" 
            name="lastname"
            className="border-2 border-dark-3 rounded-lg bg-secondary focus:border-dark-3 w-full px-3 py-3  text-gray-2"
            />

        </div>
      </div>
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
          <label className=" font-medium font-inter text-dark-4 text-[16px]">Phone Number</label>
          <input 
            type="tel" 
            name="phoneNumber"
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

       <div className="w-full grid gap-3 grid-cols-3">
       <div className="flex flex-col gap-2">
          <label className=" font-medium font-inter text-dark-4 text-[16px]">Street</label>
          <input 
            type="text" 
            name="street"
            className="border-2 border-dark-3 rounded-lg bg-secondary focus:border-dark-3 w-full px-3 py-3  text-gray-2"
            />

        </div>
        <div className="flex flex-col gap-2">
          <label className=" font-medium font-inter text-dark-4 text-[16px]">Zip Code</label>
          <input 
            type="text" 
            name="zipcode"
            className="border-2 border-dark-3 rounded-lg bg-secondary focus:border-dark-3 w-full px-3 py-3  text-gray-2"
            />

        </div>
        <div className="flex flex-col gap-2">
          <label className=" font-medium font-inter text-dark-4 text-[16px]">House Number</label>
          <input 
            type="text" 
            name="house_number"
            className="border-2 border-dark-3 rounded-lg bg-secondary focus:border-dark-3 w-full px-3 py-3  text-gray-2"
            />

        </div>
      </div>
    
       <button className=" font-semibold text-[16px] leading-6 font-inter bg-primary-1 rounded-lg text-white px-3 py-3">Sign up</button>

       <div className=" flex gap-3 justify-center items-center">
        <hr className=" bg-gray-2 h-[2px] w-[100px] opacity-20"/>
        <p className=" text-gray-3 font-inter text-[14px] leading-5">or sign up with</p> 
        <hr className="bg-gray-2 h-[2px] w-[100px] opacity-20"/>
       </div>

       {/* Agreement */}
       <p className=" text-[16px] font-medium font-inter">By continuing, you agree to our <span className=" text-primary-1"><Link to="/terms_of_service">terms of service.</Link></span></p>
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


       <p className=" font-inter text-gray-1 text-center">Already have an account? <Link to="/auth/signin" className=" text-primary-1 font-semibold font-inter">Sign in here</Link></p>
      </div>
    </form>
  </div>
  )
}

export default Signup
