# Tracking versions

The CTA system consists of several target environments (several instances of the system used for testing etc.).

In order to be able to track which particular version is deployed to which target environment we make use of git tags.

There are two types of tags.

## Pointer tags

Pointer tags "point” to the revision that is currently deployed in the corresponding target environment.

They follow the pattern {target environment name}-{subsystem}, e.g. _te-prod-analytics_ or _te-load-test-tier-metadata_ etc.

Pointer tags _move_.

## Label tags

These are permanent tags we set to keep track of releases. For example Backend-2.6 is set on the revision that was deployed for the 2.6 version in prod.

They are a historical record and do not move. Label tag naming convention is {subsystem}-{version}

For all bubbles and content we deploy independently we have both pointer and label tags.

## Current tags

Label tag prefix|Pointer tag| Bubble/Content|
---|---|---|
Backend- | {target-environment}| Main CTA system, A.K.A. AppSystem|
Analytics- | {target-environment}-analytics | Analytics subsystem|
Tiers-  | {target-environment}-i18n | Tier metadata configuration |
Availability- | {target-environment}-availability | App availability configuration|
Dashboard- | {target-environment}-pubdash| Public dashboard subsystem|
