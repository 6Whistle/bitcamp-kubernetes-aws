'use client'
import LinkButton, { linkButtonTitles } from '@/app/atoms/button/link-button';
import Link from 'next/link';
import { useEffect, useState } from 'react';
import { destroyCookie, parseCookies } from 'nookies';
import { useRouter } from 'next/navigation';
import { useDispatch } from 'react-redux';
import { logout } from '../../users/service/user-service';

function ResponsiveAppBar() {
  const router = useRouter()
  const dispatch = useDispatch()
  const [showProfile, setShowProfile] = useState(false)

  useEffect(() => {
    parseCookies().accessToken ? setShowProfile(true) : setShowProfile(false)
  }, [parseCookies().accessToken])

  const logoutHandler = () => {
    console.log("Before Logout : ", parseCookies().accessToken)
    dispatch(logout(parseCookies().accessToken))
    .then((res:any) => {})
    .catch((res:any) => {})
    destroyCookie(null, 'message')
    destroyCookie(null, 'accessToken')
    setShowProfile(false)
    router.push("/")
  }

  return <nav className="bg-white border-gray-200 dark:bg-gray-900">
  <div className="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
  <Link href="/" className="flex items-center space-x-3 rtl:space-x-reverse">
      <img src="https://flowbite.com/docs/images/logo.svg" className="h-8" alt="Flowbite Logo" />
      <span className="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Home</span>
  </Link>
  {showProfile &&
          <div className="flex items-center md:order-2 space-x-3 md:space-x-0 rtl:space-x-reverse">
            <span className="block text-sm text-gray-900 dark:text-white">Bonnie Green</span>
            <span className="block text-sm  text-gray-500 truncate dark:text-gray-400 mx-5">name@flowbite.com</span>
            <span onClick={logoutHandler} className="block text-sm  text-gray-500 truncate dark:text-gray-400"> Sign out </span>
          </div>
  }
  {/* { showProfile && <div className="flex items-center md:order-2 space-x-3 md:space-x-0 rtl:space-x-reverse">
      <button type="button" className="flex text-sm bg-gray-800 rounded-full md:me-0 focus:ring-4 focus:ring-gray-300 dark:focus:ring-gray-600" id="user-menu-button" aria-expanded="false" data-dropdown-toggle="user-dropdown" data-dropdown-placement="bottom">
        <span className="sr-only">Open user menu</span>
        <img className="w-8 h-8 rounded-full" src="https://upload.wikimedia.org/wikipedia/commons/2/2c/Default_pfp.svg" alt="user photo" />
      </button>
      <div className="z-50 my-4 text-base list-none bg-white divide-y divide-gray-100 rounded-lg shadow dark:bg-gray-700 dark:divide-gray-600" id="user-dropdown">
        <div className="px-4 py-3">
          <span className="block text-sm text-gray-900 dark:text-white">Bonnie Green</span>
          <span className="block text-sm  text-gray-500 truncate dark:text-gray-400">name@flowbite.com</span>
        </div>
        <ul className="py-2" aria-labelledby="user-menu-button">
          <li>
            <Link href="#" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Dashboard</Link>
          </li>
          <li>
            <Link href="#" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Settings</Link>
          </li>
          <li>
            <Link href="#" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Earnings</Link>
          </li>
          <li>
            <Link href="#" className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Sign out</Link>
          </li>
        </ul>
      </div>
      <button data-collapse-toggle="navbar-user" type="button" className="inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600" aria-controls="navbar-user" aria-expanded="false">
        <span className="sr-only">Open main menu</span>
        <svg className="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 17 14">
            <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M1 1h15M1 7h15M1 13h15"/>
        </svg>
    </button>
  </div>} */}
  <div className="items-center justify-between hidden w-full md:flex md:w-auto md:order-1" id="navbar-user">
    <ul className="flex flex-col font-medium p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:space-x-8 rtl:space-x-reverse md:flex-row md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">
      {linkButtonTitles.map(i => <LinkButton key = {i.id} id = {i.id} title={i.title} path={i.path} />)}
    </ul>
  </div>
  </div>
</nav>
}
export default ResponsiveAppBar;
