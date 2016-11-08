/*
 * MongoWP - MongoWP: v3.0 Library
 * Copyright © 2014 8Kdata Technology (www.8kdata.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.eightkdata.mongowp.mongoserver.api.safe.library.v3m0.pojos.index.type;

import com.eightkdata.mongowp.bson.utils.DefaultBsonValues;

public class HashedIndexType extends AbstractIndexType {

    public static final HashedIndexType INSTANCE = new HashedIndexType();

    private HashedIndexType() {
        super(DefaultBsonValues.newString("hashed"));
    }

    @Override
    public <Arg, Result> Result accept(IndexTypeVisitor<Arg, Result> visitor, Arg arg) {
        return visitor.visit(this, arg);
    }

}