select distinct user0_.id as user_id, authority2_.id as authority_id, user0_.account_expired,user0_.account_locked,
user0_.credentials_expired,user0_.enabled,user0_.password,user0_.user_name,authority2_.name,
authorities.user_id ,authorities.authority_id as authorities_authority_id from user_ user0_ 
inner join users_authorities authorities on user0_.id=authorities.user_id 
inner join authority authority2_ on authorities.authority_id=authority2_.id 
where user0_.user_name='admin' order by authority2_.id asc

select client_id, client_secret, resource_ids, scope, authorized_grant_types, web_server_redirect_uri,
authorities, access_token_validity, refresh_token_validity, additional_information,
autoapprove from oauth_client_details where client_id = 'blog-website-read-write-client'