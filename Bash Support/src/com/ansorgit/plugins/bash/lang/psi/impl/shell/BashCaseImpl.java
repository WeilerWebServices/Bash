/*
 * Copyright (c) Joachim Ansorg, mail@ansorg-it.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ansorgit.plugins.bash.lang.psi.impl.shell;

import com.ansorgit.plugins.bash.lang.lexer.BashTokenTypes;
import com.ansorgit.plugins.bash.lang.parser.BashElementTypes;
import com.ansorgit.plugins.bash.lang.psi.api.shell.BashCase;
import com.ansorgit.plugins.bash.lang.psi.impl.BashKeywordDefaultImpl;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.Collection;

/**
 * Implements the Bash Case construct.
 * <br>
 * @author jansorg
 */
public class BashCaseImpl extends BashKeywordDefaultImpl implements BashCase {
    public BashCaseImpl() {
        super(BashElementTypes.CASE_COMMAND);
    }

    public PsiElement keywordElement() {
        return findPsiChildByType(BashTokenTypes.CASE_KEYWORD);
    }

    public Collection<? extends PsiElement> patternList() {
        return PsiTreeUtil.findChildrenOfType(this, BashCasePatternListElementImpl.class);
    }

    @Override
    public boolean isCommandGroup() {
        return false;
    }
}