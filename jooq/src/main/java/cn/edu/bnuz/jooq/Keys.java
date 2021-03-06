/*
 * This file is generated by jOOQ.
*/
package cn.edu.bnuz.jooq;


import cn.edu.bnuz.jooq.tables.Account;
import cn.edu.bnuz.jooq.tables.Authority;
import cn.edu.bnuz.jooq.tables.ClassroomApply;
import cn.edu.bnuz.jooq.tables.Maintain;
import cn.edu.bnuz.jooq.tables.Session;
import cn.edu.bnuz.jooq.tables.Stuff;
import cn.edu.bnuz.jooq.tables.records.AccountRecord;
import cn.edu.bnuz.jooq.tables.records.AuthorityRecord;
import cn.edu.bnuz.jooq.tables.records.ClassroomApplyRecord;
import cn.edu.bnuz.jooq.tables.records.MaintainRecord;
import cn.edu.bnuz.jooq.tables.records.SessionRecord;
import cn.edu.bnuz.jooq.tables.records.StuffRecord;

import javax.annotation.Generated;

import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>muduo_cloud</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<ClassroomApplyRecord, Integer> IDENTITY_CLASSROOM_APPLY = Identities0.IDENTITY_CLASSROOM_APPLY;
    public static final Identity<MaintainRecord, Integer> IDENTITY_MAINTAIN = Identities0.IDENTITY_MAINTAIN;
    public static final Identity<StuffRecord, Integer> IDENTITY_STUFF = Identities0.IDENTITY_STUFF;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountRecord> KEY_ACCOUNT_PRIMARY = UniqueKeys0.KEY_ACCOUNT_PRIMARY;
    public static final UniqueKey<AuthorityRecord> KEY_AUTHORITY_PRIMARY = UniqueKeys0.KEY_AUTHORITY_PRIMARY;
    public static final UniqueKey<ClassroomApplyRecord> KEY_CLASSROOM_APPLY_PRIMARY = UniqueKeys0.KEY_CLASSROOM_APPLY_PRIMARY;
    public static final UniqueKey<MaintainRecord> KEY_MAINTAIN_PRIMARY = UniqueKeys0.KEY_MAINTAIN_PRIMARY;
    public static final UniqueKey<SessionRecord> KEY_SESSION_PRIMARY = UniqueKeys0.KEY_SESSION_PRIMARY;
    public static final UniqueKey<StuffRecord> KEY_STUFF_PRIMARY = UniqueKeys0.KEY_STUFF_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 {
        public static Identity<ClassroomApplyRecord, Integer> IDENTITY_CLASSROOM_APPLY = Internal.createIdentity(ClassroomApply.CLASSROOM_APPLY, ClassroomApply.CLASSROOM_APPLY.ID);
        public static Identity<MaintainRecord, Integer> IDENTITY_MAINTAIN = Internal.createIdentity(Maintain.MAINTAIN, Maintain.MAINTAIN.MAINTAIN_ID);
        public static Identity<StuffRecord, Integer> IDENTITY_STUFF = Internal.createIdentity(Stuff.STUFF, Stuff.STUFF.STUFF_ID);
    }

    private static class UniqueKeys0 {
        public static final UniqueKey<AccountRecord> KEY_ACCOUNT_PRIMARY = Internal.createUniqueKey(Account.ACCOUNT, "KEY_account_PRIMARY", Account.ACCOUNT.NUMBER);
        public static final UniqueKey<AuthorityRecord> KEY_AUTHORITY_PRIMARY = Internal.createUniqueKey(Authority.AUTHORITY, "KEY_authority_PRIMARY", Authority.AUTHORITY.NUMBER, Authority.AUTHORITY.AUTHORITY_);
        public static final UniqueKey<ClassroomApplyRecord> KEY_CLASSROOM_APPLY_PRIMARY = Internal.createUniqueKey(ClassroomApply.CLASSROOM_APPLY, "KEY_classroom_apply_PRIMARY", ClassroomApply.CLASSROOM_APPLY.ID);
        public static final UniqueKey<MaintainRecord> KEY_MAINTAIN_PRIMARY = Internal.createUniqueKey(Maintain.MAINTAIN, "KEY_maintain_PRIMARY", Maintain.MAINTAIN.MAINTAIN_ID);
        public static final UniqueKey<SessionRecord> KEY_SESSION_PRIMARY = Internal.createUniqueKey(Session.SESSION, "KEY_session_PRIMARY", Session.SESSION.OPENID);
        public static final UniqueKey<StuffRecord> KEY_STUFF_PRIMARY = Internal.createUniqueKey(Stuff.STUFF, "KEY_stuff_PRIMARY", Stuff.STUFF.STUFF_ID);
    }
}
